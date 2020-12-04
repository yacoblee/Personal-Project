
public class MemberVo {
	private String name;
	private String number;
	private String address;

	private String isbn;
	private String bname;
	private String bwriter;
	private String bpublish;
	private String rcofirm;
	
	public MemberVo() {
		
	}
	public MemberVo(String isbn) {
		this.isbn = isbn;
	}

	public MemberVo(String name, String number, String address) {
		this.name = name;
		this.number = number;
		this.address = address;

	}

	public MemberVo(String isbn, String bname, String bwriter, String bpublish, String rcofirm) {
		this.isbn = isbn;
		this.bname = bname;
		this.bwriter = bwriter;
		this.bpublish = bpublish;
		this.rcofirm = rcofirm;
	}

	public String name() {
		return name;
	}

	public String getnumber() {
		return number;
	}

	public String getString() {
		return address;
	}

	public String getisbn() {
		return isbn;
	}

	public String getbname() {
		return bname;
	}

	public String getbwriter() {
		return bwriter;
	}

	public String getbpublish() {
		return bpublish;
	}

	public String getrcofirm() {
		return rcofirm;
	}

}
