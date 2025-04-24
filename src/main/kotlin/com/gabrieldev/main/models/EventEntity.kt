package com.gabrieldev.main.models

import com.gabrieldev.main.enums.EventCategory
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "tb_events")
class EventEntity(
    var name: String,
    var description: String,
    var startDate: LocalDateTime,
    var endDate: LocalDateTime,
    var postalCode: String,
    @OneToOne
    @JoinColumn(name = "organizational_unit_id")
    var organizationalUnit: OrganizationalUnitEntity,
    @ElementCollection(targetClass = EventCategory::class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "event_category", joinColumns = [JoinColumn(name = "event_id")])
    @Column(name = "categories")
    var categories: List<EventCategory>,

    @OneToOne
    @JoinColumn(name = "user_id")
    var responsavel: User

) : BasicEntity()