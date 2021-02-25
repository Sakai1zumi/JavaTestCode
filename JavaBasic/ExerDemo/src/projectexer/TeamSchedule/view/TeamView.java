package projectexer.TeamSchedule.view;

import projectexer.TeamSchedule.domain.employee.Employee;
import projectexer.TeamSchedule.domain.employee.Programmer;
import projectexer.TeamSchedule.service.NameListService;
import projectexer.TeamSchedule.service.TeamException;
import projectexer.TeamSchedule.service.TeamService;

/**
 * @author TuHong
 * @create 2021-02-24 11:41
 */
public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu(){
        boolean isLoop = true;
        char menuSelection = 0;

        while(isLoop){
            if(menuSelection != '1') listAllEmployee();
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");

            menuSelection = TSUtility.readMenuSelection();
            switch (menuSelection){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N)：");
                    char isExit = TSUtility.readConfirmSelection();
                    if ((isExit == 'Y')) isLoop = false;
                    break;
            }
        }
    }

    private void listAllEmployee(){
        System.out.println("-------------------------------------开发团队调度软件--------------------------------------\n");
        System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");

        Employee[] allEmployees = listSvc.getAllEmployees();
        for(Employee e : allEmployees){
            System.out.println(e);
        }

        System.out.println("----------------------------------------------------------------------------------------------");
    }

    private void getTeam(){
        System.out.print("--------------------团队成员列表---------------------\n");

        Programmer[] team = teamSvc.getTeam();
        if(team == null || team.length == 0){
            System.out.println("开发团队没有成员！");
        }else{
            System.out.println("TDI/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for (Programmer p : team) {
                System.out.println(p.getDetailsForTeam());
            }
        }

        System.out.println("-----------------------------------------------------");
    }

    private void addMember(){
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID：");

        int id = TSUtility.readInt();

        try {
            Employee employee = listSvc.getEmployee(id);
            teamSvc.addMember(employee);
            System.out.println("添加成功！");
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }

        TSUtility.readReturn();
    }

    private void deleteMember(){
        System.out.println("---------------------删除成员---------------------");
        getTeam();
        System.out.print("请输入要删除员工的TID：");

        int memberId = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N)：");
        char isDelete = TSUtility.readConfirmSelection();

        if(isDelete == 'N') return;

        try {
            teamSvc.removeMember(memberId);
            System.out.println("删除成功！");
        } catch (TeamException e) {
            System.out.println("删除失败，原因：" + e.getMessage());
        }

        TSUtility.readReturn();
    }

    public static void main(String[] args){
        TeamView view  = new TeamView();
        view.enterMainMenu();
    }
}
