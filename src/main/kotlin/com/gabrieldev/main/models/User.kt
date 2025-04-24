package com.gabrieldev.main.models

import jakarta.persistence.*

@Entity
class User(

    var name:String,

    var email:String,

    @ManyToMany
    @JoinTable(
        name = "user_organizational_units",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "org_unit_id")]
    )
    var organizationalUnitEntities: MutableSet<OrganizationalUnitEntity> = mutableSetOf(),

    @ManyToMany
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: MutableSet<Roles> = mutableSetOf()

) : BasicEntity()