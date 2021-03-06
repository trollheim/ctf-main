package net.trollheim.security.ctf.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class AppUser implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String username;

    private String password;

    private boolean enabled;

    private int invitations;


    @OneToMany(mappedBy = "appUser", fetch = FetchType.EAGER,cascade={CascadeType.ALL})
    private Set<Submission> submissions;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER,cascade={CascadeType.ALL})
    private Set<InviteCode> inviteCodes;

    public AppUser(){
        enabled = true;
    }

    public AppUser(String username, String password) {
        enabled = true;
        this.username = username;
        this.password = password;
        invitations = 5;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(GrantedAuthorities.USER);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public Set<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(Set<Submission> submissions) {
        this.submissions = submissions;
    }

    public Set<InviteCode> getInviteCodes() {
        return inviteCodes;
    }

    public void setInviteCodes(Set<InviteCode> inviteCodes) {
        this.inviteCodes = inviteCodes;
    }
}
