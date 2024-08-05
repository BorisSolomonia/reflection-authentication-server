package com.boris.authentication_server.entity;

import com.boris.authentication_server.constant.Provider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@Entity
@Table(name = "user_detail")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "user_name")
    private String username;

    @Enumerated(EnumType.STRING)
    private Provider provider;

    private String password;

    @Column(name = "created_time")
    private Date created_time;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_time")
    private Date updated_time;

    @Column(name = "updated_by")
    private String updated_by;

    public UserDetail(String user_id, String username, Provider provider, String password, Date created_time, String created_by, Date updated_time, String updated_by) {
        this.user_id = user_id;
        this.username = username;
        this.provider = provider;
        this.password = password;
        this.created_time = created_time;
        this.created_by = created_by;
        this.updated_time = updated_time;
        this.updated_by = updated_by;
    }
}
