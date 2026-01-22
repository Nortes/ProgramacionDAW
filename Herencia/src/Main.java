//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
  Circulo c1 = new Circulo (0.54);
  System.out.println(c1.getArea());

  Circumferencia c2 = new Circumferencia(0.54, 3.2);

  System.out.println(c2.getArea());
  System.out.println(c2.getVolume());
}
