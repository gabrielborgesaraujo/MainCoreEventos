package com.gabrieldev.main.models

import jakarta.persistence.*

@Entity
class Roles(
    var role: String,
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    var members: MutableSet<User> = mutableSetOf(),
) : BasicEntity()