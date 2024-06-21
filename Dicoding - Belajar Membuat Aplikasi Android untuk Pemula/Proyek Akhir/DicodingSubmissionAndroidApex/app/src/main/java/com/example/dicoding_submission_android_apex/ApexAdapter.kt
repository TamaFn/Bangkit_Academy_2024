package com.example.dicoding_submission_android_apex

import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.parcelize.Parcelize

class ApexAdapter(private var listChar: ArrayList<ApexChar>): RecyclerView.Adapter<ApexAdapter.ApexViewHolder>(){

    override fun onBindViewHolder(holder: ApexViewHolder, position: Int) {
        val context = holder.itemView.context
        val apexCharc = listChar[position]
        Glide.with(holder.itemView.context)
            .load(apexCharc.photoprofile)
            .apply(RequestOptions())
            .into(holder.picture)
        holder.name.text = apexCharc.name
        holder.classbattle.text = apexCharc.classtype
        holder.itemView.setOnClickListener {
            val passItem = Intent(context, DetailActivity::class.java)
            passItem.putExtra(DetailActivity.EXTRA_NAME, apexCharc.name)
            passItem.putExtra(DetailActivity.EXTRA_AGE, apexCharc.age)
            passItem.putExtra(DetailActivity.EXTRA_GENDER, apexCharc.gender)
            passItem.putExtra(DetailActivity.EXTRA_HOMEWORLD, apexCharc.homeworld)
            passItem.putExtra(DetailActivity.EXTRA_CLASSTYPE, apexCharc.classtype)
            passItem.putExtra(DetailActivity.EXTRA_TACTICALABILITY, apexCharc.tacticalability)
            passItem.putExtra(DetailActivity.EXTRA_PASSIVEABILITY, apexCharc.passiveability)
            passItem.putExtra(DetailActivity.EXTRA_ULTIMATEABILITY, apexCharc.ultimateability)
            passItem.putExtra(DetailActivity.EXTRA_TACTICALABILITYDESC, apexCharc.tacticaldescription)
            passItem.putExtra(DetailActivity.EXTRA_PASSIVEABILITYDESC, apexCharc.passivedescription)
            passItem.putExtra(DetailActivity.EXTRA_ULTIMATEABILITYDESC, apexCharc.ultimatedescription)
            passItem.putExtra(DetailActivity.EXTRA_PHOTOPROFILE, apexCharc.photoprofile)
            passItem.putExtra(DetailActivity.EXTRA_PHOTOCOVER, apexCharc.photocover)
            passItem.putExtra(DetailActivity.EXTRA_ICONTACTICAL, apexCharc.icontactical)
            passItem.putExtra(DetailActivity.EXTRA_ICONPASSIVE, apexCharc.iconpassive)
            passItem.putExtra(DetailActivity.EXTRA_ICONULTIMATE, apexCharc.iconultimate)
            passItem.putExtra(DetailActivity.EXTRA_ICONCLASS, apexCharc.iconclass)

            context.startActivity(passItem)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApexViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_row_char, parent, false)
        return ApexViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listChar.size
    }

    inner class ApexViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.char_namelist)
        var classbattle: TextView = itemView.findViewById(R.id.char_classlist)
        var picture: ImageView = itemView.findViewById(R.id.char_pic)
    }

}