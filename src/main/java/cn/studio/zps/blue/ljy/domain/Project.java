package cn.studio.zps.blue.ljy.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Project {
    private int id;
    private String name;
    private short state;
    private Timestamp planFinishTime;
    private Timestamp finishTime;
    private short difficultyGrade;
    private List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != project.id) return false;
        if (state != project.state) return false;
        if (difficultyGrade != project.difficultyGrade) return false;
        if (name != null ? !name.equals(project.name) : project.name != null) return false;
        if (planFinishTime != null ? !planFinishTime.equals(project.planFinishTime) : project.planFinishTime != null)
            return false;
        if (finishTime != null ? !finishTime.equals(project.finishTime) : project.finishTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) state;
        result = 31 * result + (planFinishTime != null ? planFinishTime.hashCode() : 0);
        result = 31 * result + (finishTime != null ? finishTime.hashCode() : 0);
        result = 31 * result + (int) difficultyGrade;
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", planFinishTime=" + planFinishTime +
                ", finishTime=" + finishTime +
                ", difficultyGrade=" + difficultyGrade +
                ", tasks=" + tasks +
                '}';
    }
}
