package userapp.rk.ui.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

/**
 * Model class for storing data
 */
@Entity(primaryKeys = ["id"])
class MoviesResponse() :Parcelable {
    @SerializedName("vote_count")
    var voteCount: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("video")
    var video: Boolean = false

    @SerializedName("vote_average")
    var voteAverage: Double = 0.0


    @SerializedName("title")
    var title: String? = null

    @SerializedName("popularity")
    var popularity: Double = 0.0

    @SerializedName("poster_path")
    var posterPath: String? = null

    @SerializedName("original_language")
    var originalLanguage: String? = null

    @SerializedName("original_title")
    var originalTitle: String? = null

    @SerializedName("backdrop_path")
    var backdropPath: String? = null

    @SerializedName("adult")
    var adult: Boolean = false

    @SerializedName("overview")
    var overview: String? = null

    @SerializedName("release_date")
    var releaseDate: String? = null

    var isFavourite: Boolean = false

    constructor(parcel: Parcel) : this() {
        voteCount = parcel.readInt()
        id = parcel.readInt()
        video = parcel.readByte() != 0.toByte()
        voteAverage = parcel.readDouble()
        title = parcel.readString()
        popularity = parcel.readDouble()
        posterPath = parcel.readString()
        originalLanguage = parcel.readString()
        originalTitle = parcel.readString()
        backdropPath = parcel.readString()
        adult = parcel.readByte() != 0.toByte()
        overview = parcel.readString()
        releaseDate = parcel.readString()
        isFavourite = parcel.readByte() != 0.toByte()
    }

    override fun equals(other: Any?): Boolean {
        if (other === this)
            return true

        val movieResponse = other as? MoviesResponse?
        return movieResponse?.id == this.id
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(voteCount)
        parcel.writeInt(id)
        parcel.writeByte(if (video) 1 else 0)
        parcel.writeDouble(voteAverage)
        parcel.writeString(title)
        parcel.writeDouble(popularity)
        parcel.writeString(posterPath)
        parcel.writeString(originalLanguage)
        parcel.writeString(originalTitle)
        parcel.writeString(backdropPath)
        parcel.writeByte(if (adult) 1 else 0)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
        parcel.writeByte(if (isFavourite) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun hashCode(): Int {
        var result = voteCount
        result = 31 * result + id
        result = 31 * result + video.hashCode()
        result = 31 * result + voteAverage.hashCode()
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + popularity.hashCode()
        result = 31 * result + (posterPath?.hashCode() ?: 0)
        result = 31 * result + (originalLanguage?.hashCode() ?: 0)
        result = 31 * result + (originalTitle?.hashCode() ?: 0)
        result = 31 * result + (backdropPath?.hashCode() ?: 0)
        result = 31 * result + adult.hashCode()
        result = 31 * result + (overview?.hashCode() ?: 0)
        result = 31 * result + (releaseDate?.hashCode() ?: 0)
        result = 31 * result + isFavourite.hashCode()
        return result
    }

    companion object CREATOR : Parcelable.Creator<MoviesResponse> {
        override fun createFromParcel(parcel: Parcel): MoviesResponse {
            return MoviesResponse(parcel)
        }

        override fun newArray(size: Int): Array<MoviesResponse?> {
            return arrayOfNulls(size)
        }
    }

}