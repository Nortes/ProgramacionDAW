//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
  Circulo c1 = new Circulo (0.54);
  System.out.println(c1.getArea());

  Circumferencia c2 = new Circumferencia(0.54, 3.2);

  System.out.println(c2.getArea());
  System.out.println(c2.getVolume());

  Impresora hP3200=new Impresora(true);

  hP3200.toString();

  System.out.println("Se intenta rellenar la impresora con 30%: "+hP3200.rellenaToner(30));
  System.out.println("Se intenta rellenar la impresora con -30%: "+hP3200.rellenaToner(-30));
  System.out.println("Se intenta rellenar la impresora con 300%: "+hP3200.rellenaToner(300));
  System.out.println("Se intenta rellenar la impresora con 75%: "+hP3200.rellenaToner(75));
  System.out.println("Se intenta rellenar la impresora con 43%: "+hP3200.rellenaToner(43));
  System.out.println("Se intenta rellenar la impresora con 27%: "+hP3200.rellenaToner(27));

  System.out.println("La impresora lleva impresas: "+hP3200.getPaginasImpresas()+" hojas.");
  System.out.println("Mandamos imprimir 2 páginas: "+hP3200.imprime(2)+" hojas");
  System.out.println("La impresora lleva impresas: "+hP3200.getPaginasImpresas()+" hojas.");
  System.out.println("Mandamos imprimir -2 páginas: "+hP3200.imprime(-2)+" hojas");
  System.out.println("La impresora lleva impresas: "+hP3200.getPaginasImpresas()+" hojas.");
  System.out.println("Mandamos imprimir 5 páginas: "+hP3200.imprime(5)+" hojas");
  System.out.println("La impresora lleva impresas: "+hP3200.getPaginasImpresas()+" hojas.");
  System.out.println("Mandamos imprimir 132 páginas: "+hP3200.imprime(132)+" hojas");
  System.out.println("La impresora lleva impresas: "+hP3200.getPaginasImpresas()+" hojas.");
  System.out.println("Mandamos imprimir 200 páginas: "+hP3200.imprime(200)+" hojas");
  System.out.println("La impresora lleva impresas: "+hP3200.getPaginasImpresas()+" hojas.");



}
