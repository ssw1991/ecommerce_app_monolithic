package com.shilo.ecommerce.ecom_mono.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="roles",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "role_name"),
        })
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "role_id")
    private Integer roleId;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, name = "role_name")
    private AppRole roleName;

    public Role(AppRole roleName) {
        this.roleName = roleName;
    }
}
