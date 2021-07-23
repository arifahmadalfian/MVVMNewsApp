package com.arifahmadalfian.mvvmnewsapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.arifahmadalfian.mvvmnewsapp.core.model.Articles
import com.arifahmadalfian.mvvmnewsapp.databinding.ItemArticlePreviewBinding
import com.bumptech.glide.Glide

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    private val differentCallback = object : DiffUtil.ItemCallback<Articles>() {
        override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, differentCallback)

    private var onItemClickListener: ((Articles) -> Unit)? = null

    fun setOnItemClickListener(listener: (Articles) -> Unit) {
        onItemClickListener = listener
    }

    inner class ArticleViewHolder(private var binding: ItemArticlePreviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(articles: Articles) {
            with(binding) {
                Glide.with(binding.root)
                    .load(articles.urlToImage)
                    .into(ivArticleImage)
                tvSource.text = articles.source.name
                tvTitle.text = articles.title
                tvDescription.text = articles.description
                tvPublishedAt.text = articles.publishedAt

                setOnItemClickListener {
                    onItemClickListener?.let { it(articles) }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}