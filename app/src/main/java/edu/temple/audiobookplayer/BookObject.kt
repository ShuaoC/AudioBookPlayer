package edu.temple.audiobookplayer;

import android.os.Parcel
import android.os.Parcelable

data class BookObject(val title: String?, val author: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object CREATOR : Parcelable.Creator<BookObject> {
        override fun createFromParcel(parcel: Parcel): BookObject {
            return BookObject(parcel)
        }

        override fun newArray(size: Int): Array<BookObject?> {
            return arrayOfNulls(size)
        }
    }
}
