package com.sebas.tiendagenerica.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.sebas.tiendagenerica.dao.ProductoDAO;
import com.sebas.tiendagenerica.model.ProductoModel;
import com.sebas.tiendagenerica.model.ProveedorModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;


@RestController
public class UploadController {
    @Autowired
    ProductoDAO productoDAO;
    ProveedorModel proveedor;

    @PostMapping("/upload")
    public String uploadData(@RequestParam("file") MultipartFile file) throws Exception {
        List<ProductoModel> productoList = new ArrayList<>();
        InputStream inputStream = file.getInputStream();
        CsvParserSettings setting = new CsvParserSettings();
        setting.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(setting);
        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
        parseAllRecords.forEach(record -> {
            ProductoModel producto = new ProductoModel();
            producto.setNombre_producto(record.getString("nombre_producto"));
            proveedor.setNitproveedor(Long.parseLong(record.getString("nit_proveedor")));
            producto.setPrecio_compra(Double.parseDouble(record.getString("precio_compra")));
            producto.setIvacompra(Double.parseDouble(record.getString("ivacompra")));
            producto.setPrecio_venta(Double.parseDouble(record.getString("precio_venta")));
            productoList.add(producto);
        });
        productoDAO.saveAll(productoList);
        return "Carga hecha";
    }
}
