package entity;

public class Candidate {
    private int cId;
    private String cName;
    private String cParty;
    private int voteCount;
    private int voterId; // References Voter table

    public Candidate() {
    }

    public Candidate(int cId, String cName, String cParty, int voteCount, int voterId) {
        this.cId = cId;
        this.cName = cName;
        this.cParty = cParty;
        this.voteCount = voteCount;
        this.voterId = voterId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcParty() {
        return cParty;
    }

    public void setcParty(String cParty) {
        this.cParty = cParty;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cParty='" + cParty + '\'' +
                ", voteCount=" + voteCount +
                ", voterId=" + voterId +
                '}';
    }
}

