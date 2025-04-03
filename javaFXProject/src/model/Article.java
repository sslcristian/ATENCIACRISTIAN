package model;

public class Article {
    private String titulo;
    private String autor;
    private long ISSN;
    private int year;
    private boolean availability;
	public Article(String titulo, String autor, long iSSN, int year, boolean availability) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		ISSN = iSSN;
		this.year = year;
		this.availability = availability;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public long getISSN() {
		return ISSN;
	}
	public void setISSN(long iSSN) {
		ISSN = iSSN;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	

    public static boolean validarISSN(long ISSN) {
        return String.valueOf(ISSN).matches("[0-9]{8}");
    }

	
	
	@Override
	public String toString() {
		return "Article [titulo=" + titulo + ", autor=" + autor + ", ISSN=" + ISSN + ", year=" + year
				+ ", availability=" + availability + "]";
	}
    
    
}
