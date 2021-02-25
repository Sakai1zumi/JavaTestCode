package projectexer.TeamSchedule.service;

import projectexer.TeamSchedule.domain.employee.Architect;
import projectexer.TeamSchedule.domain.employee.Designer;
import projectexer.TeamSchedule.domain.employee.Employee;
import projectexer.TeamSchedule.domain.employee.Programmer;

/**
 * @author TuHong
 * @create 2021-02-24 11:37
 */
public class TeamService {
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    public TeamService() {
    }

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < total; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException{
//        成员已满，无法添加
        if(total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
//        该成员不是开发人员，无法添加
        if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
//        该员工已在本开发团队中
        Programmer p = (Programmer) e;
        if(isExist(p)){
            throw new TeamException("该员工已在本开发团队中");
        }
//        该员工已是某团队成员
//        该员正在休假，无法添加
        switch(p.getStatus()){
            case BUSY:
                throw new TeamException("该员工已是某团队成员");
            case VACATION:
                throw new TeamException("该员正在休假，无法添加");
        }
//        团队中至多只能有一名架构师
//        团队中至多只能有两名设计师
//        团队中至多只能有三名程序员
        int numOfArc = 0,numOfDes = 0,numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if(team[i] instanceof Architect){
                numOfArc++;
            }else if(team[i] instanceof Designer){
                numOfDes++;
            }else{
                numOfPro++;
            }
        }

        if(p instanceof Architect){
            if(numOfArc >= 1){
                throw new TeamException("团队中至多只能有一名架构师");
            }
        }else if(p instanceof Designer){
            if(numOfDes >= 2){
                throw new TeamException("团队中至多只能有两名设计师");
            }
        }else{
            if(numOfPro >= 3){
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);

    }



    public void removeMember(int memberId) throws TeamException{
        int i = 0;
        for (; i < total; i++) {
            if(team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        if(i == total){
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }

        for(int j = i;j < total - 1;j++){
            team[j] = team[j + 1];
        }

        team[--total] = null;
    }

    private boolean isExist(Programmer p){
        for (int i = 0; i < total; i++) {
            if(p.getId() == team[i].getId()){
                return true;
            }
        }

        return false;
    }
}
