package ABC;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto producto = new Producto();

        producto.crearProducto(1, 1001, "Laptop X", 25000, 10, "MarcaX");

        System.out.println("Lista de productos:");
        producto.leerProductos();

        producto.actualizarProducto(1001, 0, "Laptop X Pro", 27000, 8, "MarcaX");

        System.out.println("Lista de productos después de la actualización:");
        producto.leerProductos();

        producto.eliminarProducto(1001);

        System.out.println("Lista de productos después de la eliminación:");
        producto.leerProductos();

	}

}
