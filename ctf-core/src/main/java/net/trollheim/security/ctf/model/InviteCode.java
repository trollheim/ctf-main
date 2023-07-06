package net.trollheim.security.ctf.model;

import javax.persistence.*;

@Entity
public class InviteCode {

    public static final String SEPARATOR = ":::";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Organisation getOwner() {
        return owner;
    }

    public void setOwner(Organisation owner) {
        this.owner = owner;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Organisation owner;

    @OneToOne
    @JoinColumn(name = "applicant_id")
    private AppUser applicant;

    private String inviteCode;

    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public AppUser getApplicant() {
        return applicant;
    }

    public void setApplicant(AppUser applicant) {
        this.applicant = applicant;
    }



 }
