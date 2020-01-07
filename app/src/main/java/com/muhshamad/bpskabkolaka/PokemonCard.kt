package com.muhshamad.bpskabkolaka

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PokemonCard(
    var name: String?,
    @SerializedName("imageUrl") var image: String?,
    var rarity: String?,
    var series: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    data class PokemonCardResponse(
        var cards: MutableList<PokemonCard>
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeString(rarity)
        parcel.writeString(series)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonCard> {
        override fun createFromParcel(parcel: Parcel): PokemonCard {
            return PokemonCard(parcel)
        }

        override fun newArray(size: Int): Array<PokemonCard?> {
            return arrayOfNulls(size)
        }
    }
}