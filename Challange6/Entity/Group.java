package Challange6.Entity;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupId;
    private String groupName;
    private List<User> members;
    private List<Expence> expences;
    public Group(String groupId, String groupName, List<User> members) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.members = new ArrayList<>(members);
        this.expences = new ArrayList<>();
    }
    public String getGroupId() {
        return groupId;
    }
    public String getGroupName() {
        return groupName;
    }
    public List<User> getMembers() {
        return members;
    }
    public List<Expence> getExpences() {
        return expences;
    }
    public void addExpence(Expence expence) {
        expences.add(expence);
    }
}
