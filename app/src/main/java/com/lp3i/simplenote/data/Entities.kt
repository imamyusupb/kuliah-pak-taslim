package com.lp3i.simplenote.data

import androidx.room.*

@Entity(tableName = "food")
data class Makanan(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "nama") val name: String,
    @ColumnInfo(name = "bahan_bahan") val ingredient: String,
    @ColumnInfo(name = "cara_memasak") val cooking: String,
)

@Entity(tableName = "family_member")
data class FamilyMember(
    @PrimaryKey
    @ColumnInfo(name = "member_id")val memberId: Long,
    @ColumnInfo(name = "member_name") val name: String
)

data class MakananAndFamilyMember(
    @Embedded val makanan: Makanan,
    @Relation(
        parentColumn = "id",
        entityColumn = "member_id"
    )
    val familyMembers: List<FamilyMember>
)
