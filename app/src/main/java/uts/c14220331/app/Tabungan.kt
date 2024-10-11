package uts.c14220331.app

import android.os.Parcel
import android.os.Parcelable

data class Tabungan(
    var amount: Int,
):Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(amount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tabungan> {
        override fun createFromParcel(parcel: Parcel): Tabungan {
            return Tabungan(parcel)
        }

        override fun newArray(size: Int): Array<Tabungan?> {
            return arrayOfNulls(size)
        }
    }
}
