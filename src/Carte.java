class Carte {
	private String type;
	private int valeur ;
	
	public Carte ( int valeur ,String type ) {
		this.type=type;
		this.valeur=valeur;
	}

	public String afficher () {
		switch (valeur) {
			case 1 :return("As-"+type);
			
			case 11 : return("Valet-"+type);
			
			case 12 :return("Dame-"+type);
				
			case 13 :return("Roi-"+type);
				
			default :return (valeur+"-"+type);
		}
	}
	
	public String getType () {
		return (type);
	}
	public int getVal (){
		return(valeur);
	}						
}