package net.trollheim.security.ctf.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Submission {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sub_seq"
    )
    @SequenceGenerator(
            name = "sub_seq"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "flag_id")
    Flag flag;

    LocalDateTime submission;

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public LocalDateTime getSubmission() {
        return submission;
    }

    public void setSubmission(LocalDateTime submission) {
        this.submission = submission;
    }
}
