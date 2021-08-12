package net.trollheim.security.ctf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InviteCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //TODO  AppUser owner; AppUser applicant


    String inviteCode;



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
}
