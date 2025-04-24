package com.gabrieldev.main.models

import jakarta.persistence.*
import java.io.Serializable

@MappedSuperclass
abstract class BasicEntity : Serializable{

    private var _id: Long? = null

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
    @get:Access(AccessType.PROPERTY)
    val id: Long?
        get() = _id

    protected fun setId(id:Long){
        this._id = id
    }
}