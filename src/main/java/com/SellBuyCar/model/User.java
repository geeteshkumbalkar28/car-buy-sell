package com.SellBuyCar.model;

import com.SellBuyCar.dto.RegisterDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id_generator")
    @SequenceGenerator(name = "user_id_generator", initialValue = 1000)
    private int id;

    @Column(name = "email", nullable = false, length = 250)
    private String email;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "password", nullable = false, length = 250)
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Userprofile profile;

//    @OneToOne(mappedBy = "userUser",cascade = CascadeType.ALL)
//    private Dealer dealers;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles=new HashSet<>();

    public User(RegisterDto registerDto) {
        this.email = registerDto.getEmail();
        this.mobileNo = registerDto.getMobileNo();
        this.password = registerDto.getPassword();
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}