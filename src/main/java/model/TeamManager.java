package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TeamManager extends AbstractEmployee implements IManager {

    private List<IEmployee> employees;
    private int limit;
    private Random random = new Random();

    public TeamManager(PersonalData personalData, Role role, int limit) {
        super(personalData, role);
        this.limit = limit;
        this.employees = new LinkedList<>();
    }

    @Override
    public void hire(IEmployee employee) {
        employees.add(employee);
    }

    @Override
    public void fire(IEmployee employee) {
        employees.remove(employee);
    }

    @Override
    public boolean canHire() {
        return limit > employees.size();
    }

    @Override
    public void assign(Task task) {
        if(employees.size()!=0) {
            IEmployee employee = employees.get(random.nextInt(employees.size()));
            employee.assign(task);
        }
    }

    @Override
    public Report reportWork() {
        List<Task> tasks = new LinkedList<>();

        for(IEmployee e : employees){
            if(e instanceof Developer) {
                Developer developer = (Developer) e;
                tasks.addAll(developer.getTasks());
            }
        }
        return new Report(this,tasks);
    }

    public List<IEmployee> getEmployees() {
        return employees;
    }
}
