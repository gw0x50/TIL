package day6;

public class BookMgr {
	Book[] booklist;

	BookMgr(Book[] booklist) {
		this.booklist = booklist;
	}

	@Override
	public String toString() {
		String text = "";
		int sum = 0;

		for (int i = 0; i < booklist.length; i++) {
			sum += booklist[i].getPrice();
			text += String.format("%-20s", booklist[i].getTitle()) + "| " + booklist[i].getPrice() + "\n";
		}
		text += "전체 책 가격의 합 : " + sum;

		return text;
	}

}
