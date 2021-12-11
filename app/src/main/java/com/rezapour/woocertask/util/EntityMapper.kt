package com.rezapour.woocertask.util

interface EntityMapper<Entity, DomailModel> {
    fun mapFromEntity(entity: Entity): DomailModel

    // TODO: 12/11/21
    fun mapToEntity(domailModel: DomailModel, a:Entity): Entity{
        return a
    }
}