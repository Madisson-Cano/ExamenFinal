package ABC;

import java.sql.*;

public class Producto {
    private String url = "jdbc:mysql://localhost:3307/EXAMEN"; 
    private String usuario = "root"; 
    private String contraseña = "1234"; 

    public void crearProducto(int enVenta, int identificador, String nombre, int precio, int cantidad, String marca) {
        String sql = "INSERT INTO COMPUTADORAS (EN_VENTA, IDENTIFICADOR, NOMBRE, PRECIO, CANTIDAD, MARCA) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            pstmt.setInt(1, enVenta);
            pstmt.setInt(2, identificador);
            pstmt.setString(3, nombre);
            pstmt.setInt(4, precio);
            pstmt.setInt(5, cantidad);
            pstmt.setString(6, marca);
            
            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Producto creado. Filas afectadas: " + filasAfectadas);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void leerProductos() {
        String sql = "SELECT * FROM COMPUTADORAS";
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                int enVenta = rs.getInt("EN_VENTA");
                int identificador = rs.getInt("IDENTIFICADOR");
                String nombre = rs.getString("NOMBRE");
                int precio = rs.getInt("PRECIO");
                int cantidad = rs.getInt("CANTIDAD");
                String marca = rs.getString("MARCA");
                System.out.println("En Venta: " + enVenta + ", ID: " + identificador + ", Nombre: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad + ", Marca: " + marca);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProducto(int identificador, int enVenta, String nombre, int precio, int cantidad, String marca) {
        String sql = "UPDATE COMPUTADORAS SET EN_VENTA = ?, NOMBRE = ?, PRECIO = ?, CANTIDAD = ?, MARCA = ? WHERE IDENTIFICADOR = ?";
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            pstmt.setInt(1, enVenta);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, precio);
            pstmt.setInt(4, cantidad);
            pstmt.setString(5, marca);
            pstmt.setInt(6, identificador);
            
            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Producto actualizado. Filas afectadas: " + filasAfectadas);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProducto(int identificador) {
        String sql = "DELETE FROM COMPUTADORAS WHERE IDENTIFICADOR = ?";
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
            pstmt.setInt(1, identificador);
            
            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Producto eliminado. Filas afectadas: " + filasAfectadas);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
