package com.gabrieldev.main.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToMany
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class OrganizationalUnitEntity(
    var name: String,

    @CreationTimestamp
    @Column(updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @ManyToMany(mappedBy = "organizationalUnits", fetch = FetchType.LAZY)
    var members: MutableSet<User> = mutableSetOf(),
) : BasicEntity()