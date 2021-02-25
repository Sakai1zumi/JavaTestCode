package projectexer.TeamSchedule.service;

/**
 * @author TuHong
 * @create 2021-02-24 11:34
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -3387516993124228848L;

    public TeamException() {
    }

    public TeamException(String msg){
        super(msg);
    }
}
