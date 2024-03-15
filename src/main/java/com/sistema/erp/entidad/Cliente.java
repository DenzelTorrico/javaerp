package com.sistema.erp.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Long id;
		public String name;
		public String address;
		public String phone;
		//ready ENUM
	    @Enumerated(EnumType.STRING)
	    @Column(columnDefinition = "ENUM('ACTIVO', 'INACTIVO') DEFAULT 'ACTIVO'")
		private TipoEstado estado = TipoEstado.ACTIVO;
		
		public TipoEstado getEstado() {
			return estado;
		}
		public void setEstado(TipoEstado estado) {
			this.estado = estado;
		}
		public String email;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		} 
		
		
		
}
