package cn.studio.zps.blue.ljy.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
@Entity
public class Task {
    private int taskId;
    private long principalID;
    private String name;
    private short state;
    private Timestamp planFinishTime;
    private Timestamp finishTime;
    private short difficultyGrade;

    @Id
    @Column(name = "task_id")
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "state")
    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    @Basic
    @Column(name = "plan_finish_time")
    public Timestamp getPlanFinishTime() {
        return planFinishTime;
    }

    public void setPlanFinishTime(Timestamp planFinishTime) {
        this.planFinishTime = planFinishTime;
    }

    @Basic
    @Column(name = "finish_time")
    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "difficulty_grade")
    public short getDifficultyGrade() {
        return difficultyGrade;
    }

    public void setDifficultyGrade(short difficultyGrade) {
        this.difficultyGrade = difficultyGrade;
    }

    public long getPrincipalID() {
        return principalID;
    }

    public void setPrincipalID(long principalID) {
        this.principalID = principalID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (taskId != task.taskId) return false;
        if (state != task.state) return false;
        if (difficultyGrade != task.difficultyGrade) return false;
        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        if (planFinishTime != null ? !planFinishTime.equals(task.planFinishTime) : task.planFinishTime != null)
            return false;
        if (finishTime != null ? !finishTime.equals(task.finishTime) : task.finishTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) state;
        result = 31 * result + (planFinishTime != null ? planFinishTime.hashCode() : 0);
        result = 31 * result + (finishTime != null ? finishTime.hashCode() : 0);
        result = 31 * result + (int) difficultyGrade;
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", planFinishTime=" + planFinishTime +
                ", finishTime=" + finishTime +
                ", difficultyGrade=" + difficultyGrade +
                '}';
    }
}
