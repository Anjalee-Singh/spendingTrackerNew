package com.expense.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.expense.pdf.PdfDetails;

public class ExpenseIterator{
	
	List<PdfDetails> pdfDetailList;
	
	public ExpenseIterator() {
		pdfDetailList = new ArrayList<PdfDetails>();
	}

	public void addPdfDetails(PdfDetails pdfDetails) {
		pdfDetailList.add(pdfDetails);
	}

	public Iterator<PdfDetails> iterator() {
		return new CategoryIterator();
	}

	
	
	class CategoryIterator implements Iterator<PdfDetails> {
		int currentIndex = 0;

		@Override
		public boolean hasNext() {
			if (currentIndex >= pdfDetailList.size()) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public PdfDetails next() {
			return pdfDetailList.get(currentIndex++);
		}

		@Override
		public void remove() {
			pdfDetailList.remove(--currentIndex);
		}

	}

}
