package com.example.newsmvvmapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsmvvmapplication.R
import com.example.newsmvvmapplication.databinding.ItemsNewsBinding
import com.example.newsmvvmapplication.pojo.Article

class NewsAdapter() :RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: ItemsNewsBinding):RecyclerView.ViewHolder(itemView.root){
        var newsImage: ImageView = itemView.imgNews
        var txtTitle: TextView = itemView.txttitle
        var txtdesp: TextView = itemView.txtdesp
        var txtAuth: TextView = itemView.txtAuth
        var txtsource: TextView = itemView.textView6
    }

    private val differCallBack = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
           return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this,differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemsNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(holder.newsImage)
            holder.txtTitle.text = article.title
            holder.txtdesp.text = article.description
            holder.txtAuth.text = article.author
            holder.txtsource.text = article.publishedAt
        }
    }
}