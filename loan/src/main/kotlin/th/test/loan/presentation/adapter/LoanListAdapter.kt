package th.test.loan.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_loan.view.*
import th.test.loan.R
import th.test.loan.data.entity.model.LoanModel
import kotlin.properties.Delegates

class LoanListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items by Delegates.observable(listOf<LoanModel>()) { _, _, _ ->
        notifyDataSetChanged()
    }

    var onSelectItem: (loanModel: LoanModel) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_loan, parent, false)
        return LoanViewHolder(view = view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as LoanViewHolder).bind(loanModel = items[position])
    }

    inner class LoanViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        init {
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onSelectItem.invoke(items[adapterPosition])
                }
            }
        }

        fun bind(loanModel: LoanModel) {
            itemView.apply {
                loanModel.id?.let {
                    idTextView.text = it.toString()
                }

                loanModel.loan_amount?.let {
                    amountTextView.text = it.toString()
                }

                loanModel.loan_term?.let {
                    termTextView.text = it.toString()
                }

                loanModel.interest_rate?.let {
                    interestTextView.text = it.toString()
                }
            }
        }
    }
}