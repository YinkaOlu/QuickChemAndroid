package com.yinkaolu.quickchemandroid.data.model

import com.google.gson.annotations.SerializedName

/**
 * Atomic Element information from data source
 * TODO: Have separate data class for Client Element data & API Element data
 */
class Element(
    val symbol: String = "",
    val appearance: String = "",
    @SerializedName("atomic_number")
    val atomicNumber: String = "",
    val group: String = "",
    val period: String = "",
    @SerializedName("element_category")
    val elementCategory: String = "",
    @SerializedName("standard_atomic_weight")
    val standardAtomicWeight: String = "",
    @SerializedName("electron_configuration")
    val electronConfiguration: String = "",
    @SerializedName("per_shell")
    val perShell: String = "",
    val phase: String = "",
    @SerializedName("melting_point")
    val meltingPoint: String = "",
    @SerializedName("boiling_point")
    val boilingPoint: String = "",
    val density: String = "",
    @SerializedName("heat_of_fusion")
    val heatOfFusion: String = "",
    @SerializedName("heat_of_vaporization")
    val heatOfVaporization: String = "",
    @SerializedName("molar_heat_capacity")
    val molarHeatCapacity: String = "",
    @SerializedName("ionization_energies")
    val ionizationEnergies: String = "",
    @SerializedName("covalent_radius")
    val covalentRadius: String = "",
    @SerializedName("crystal_structure")
    val crystalStructure: String = "",
    val discovery: String = "",
    val summary: String = ""
)