package com.yinkaolu.quickchemandroid.data.model

import android.util.Log
import java.util.*

class PeriodicTable(var mElements: ArrayList<Element>) {
    var alkaliMetal: ArrayList<Element> = arrayListOf()
    var alkalineEarthMetals = ArrayList<Element>()
    var lanthanide = ArrayList<Element>()
    var actinide = ArrayList<Element>()
    var transitionMetal = ArrayList<Element>()
    var postTransitionMetal: ArrayList<Element> = arrayListOf()
    var metalloid = ArrayList<Element>()
    var polyatomicNonmetal = ArrayList<Element>()
    var diatomicNonmetal = ArrayList<Element>()
    var nobleGas = ArrayList<Element>()
    private val alkaliMetalNumbers = intArrayOf(3, 11, 19, 37, 55, 87)
    private val alkalineEarthMetalNums = intArrayOf(4, 12, 20, 38, 56, 88)
    private val transitionMetalNums = intArrayOf(
        21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48,
        72, 73, 74, 75, 76, 77, 78, 79, 80,
        104, 105, 106, 107, 108, 112
    )
    private val lanthanideNums =
        intArrayOf(71, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70)
    private val actinideNums =
        intArrayOf(103, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102)
    private val postTranstionNum = intArrayOf(13, 31, 49, 50, 81, 82, 83, 84, 114)
    private val metalloidNumbers = intArrayOf(5, 14, 32, 33, 51, 52, 85)
    private val polyatomicNums = intArrayOf(6, 15, 16, 34)
    private val diatomicNums = intArrayOf(1, 7, 8, 9, 17, 35, 53)
    private val nobleGasNums = intArrayOf(2, 10, 18, 36, 54, 86)
//    fun printElementNames() {
//        var title = ""
//        for (element in mElements) {
//            title += element.symbol + "\n"
//        }
//        Log.i(TAG, title)
//    }
    init {
        setAlkaliMetal()
        setAlkalineEarthMetals()
        setTranstionMetal()
        setLanthanide()
        setActinide()
        setPostTransitionMetal()
        setMetalloid()
        setPolyatomicNonmetal()
        setDiatomicNonmetal()
        setNobleGas()
    }

    private fun setAlkaliMetal(): ArrayList<Element> {
        Log.i(TAG, "Getting Alkali Metal")
        for (i in mElements.indices) {
            val atomic_number: Int = mElements[i].atomicNumber?.toInt() ?: 0
            for (alkaliNum in alkaliMetalNumbers) {
                if (atomic_number == alkaliNum) {
                    Log.i(TAG, mElements[i].symbol)
                    alkaliMetal.add(mElements[i])
                }
            }
        }
        return alkaliMetal
    }

    private fun setAlkalineEarthMetals(): ArrayList<Element> {
        Log.i(TAG, "Getting Alkaline Earth Metals")
        for (i in mElements.indices) {
            val atomic_number: Int = mElements[i].atomicNumber?.toInt() ?: 0
            for (alkaliNum in alkalineEarthMetalNums) {
                if (atomic_number == alkaliNum) {
                    Log.i(TAG, mElements[i].symbol)
                    alkalineEarthMetals.add(mElements[i])
                }
            }
        }
        return alkalineEarthMetals
    }

    private fun setTranstionMetal(): ArrayList<Element> {
        Log.i(TAG, "Getting Transition Metal")
        for (i in mElements.indices) {
            val atomic_number: Int = mElements[i].atomicNumber?.toInt() ?: 0
            for (periodicNum in transitionMetalNums) {
                if (atomic_number == periodicNum) {
                    Log.i(TAG, mElements[i].symbol)
                    transitionMetal.add(mElements[i])
                }
            }
        }
        return transitionMetal
    }


    private fun setLanthanide(): ArrayList<Element> {
        Log.i(TAG, "Getting Lanthanide")
        for (i in mElements.indices) {
            val atomic_number: Int = mElements[i].atomicNumber?.toInt() ?: 0
            for (posNum in lanthanideNums) {
                if (atomic_number == posNum) {
                    Log.i(TAG, mElements[i].symbol)
                    lanthanide.add(mElements[i])
                }
            }
        }
        return lanthanide
    }

    private fun setActinide(): ArrayList<Element> {
        Log.i(TAG, "Getting Actinide")
        for (i in mElements.indices) {
            val atomic_number: Int = mElements[i].atomicNumber?.toInt() ?: 0
            for (posNum in actinideNums) {
                if (atomic_number == posNum) {
                    Log.i(TAG, mElements[i].symbol)
                    actinide.add(mElements[i])
                }
            }
        }
        return actinide
    }

    private fun setPostTransitionMetal(): ArrayList<Element>
    {
        Log.i(TAG, "Getting Post Transition Metal")
        for (i in mElements.indices) {
            val atomic_number: Int = mElements[i].atomicNumber.toInt() ?: 0
            for (posNum in postTranstionNum) {
                if (atomic_number == posNum) {
                    Log.i(TAG, mElements[i].symbol)
                    postTransitionMetal.add(mElements.get(i))
                }
            }
        }
        return postTransitionMetal
    }

    private fun setMetalloid(): ArrayList<Element> {
        Log.i(TAG, "Getting Metalloid")
        for (i in mElements.indices) {
            val atomic_number: Int = mElements[i].atomicNumber?.toInt() ?: 0
            for (posNum in metalloidNumbers) {
                if (atomic_number == posNum) {
                    Log.i(TAG, mElements[i].symbol)
                    metalloid.add(mElements[i])
                }
            }
        }
        return metalloid
    }

    private fun setPolyatomicNonmetal(): ArrayList<Element> {
        Log.i(TAG, "Getting Polyatomic nonmetal")
        for (i in mElements.indices) {
            val atomic_number: Int = mElements[i].atomicNumber?.toInt() ?: 0
            for (posNum in polyatomicNums) {
                if (atomic_number == posNum) {
                    Log.i(TAG, mElements[i].symbol)
                    polyatomicNonmetal.add(mElements[i])
                }
            }
        }
        return polyatomicNonmetal
    }

    private fun setDiatomicNonmetal(): ArrayList<Element> {
        Log.i(TAG, "Getting Diatomic nonmetal")
        for (i in mElements.indices) {
            val atomic_number: Int = mElements[i].atomicNumber?.toInt() ?: 0
            for (posNum in diatomicNums) {
                if (atomic_number == posNum) {
                    Log.i(TAG, mElements[i].symbol)
                    diatomicNonmetal.add(mElements[i])
                }
            }
        }
        return diatomicNonmetal
    }

    private fun setNobleGas(): ArrayList<Element> {
        Log.i(TAG, "Getting Noble Gas")
        for (i in mElements.indices) {
            val atomic_number: Int = mElements[i].atomicNumber?.toInt() ?: 0
            for (posNum in nobleGasNums) {
                if (atomic_number == posNum) {
                    Log.i(TAG, mElements[i].symbol)
                    nobleGas.add(mElements[i])
                }
            }
        }
        return nobleGas
    }

    companion object {
        val TAG = PeriodicTable::class.java.simpleName
    }

}