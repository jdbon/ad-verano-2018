USE [ad-verano]
GO
/****** Object:  Table [dbo].[articulos]    Script Date: 21/02/2018 08:43:57 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[articulos](
	[art_id] [int] IDENTITY(1,1) NOT NULL,
	[art_desc] [nvarchar](50) NOT NULL,
	[art_tamanio] [int] NOT NULL,
	[art_precio_vta] [float] NOT NULL,
	[art_cant_res] [int] NOT NULL,
	[art_cant_x_comprar] [int] NOT NULL,
	[art_unidad] [nvarchar](50) NOT NULL,
	[art_presentacion] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_articulos] PRIMARY KEY CLUSTERED 
(
	[art_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[clientes]    Script Date: 21/02/2018 08:43:57 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[clientes](
	[cli_id] [int] IDENTITY(1,1) NOT NULL,
	[cli_apellido] [nvarchar](50) NOT NULL,
	[cli_nombre] [nvarchar](50) NOT NULL,
	[cli_limite_credito] [float] NOT NULL,
	[cli_saldo_actual] [float] NOT NULL,
	[cli_tfa] [nvarchar](1) NOT NULL,
 CONSTRAINT [PK_clientes] PRIMARY KEY CLUSTERED 
(
	[cli_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[facturas]    Script Date: 21/02/2018 08:43:57 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[facturas](
	[fac_id] [int] IDENTITY(1,1) NOT NULL,
	[fac_cli] [int] NOT NULL,
	[fac_tfa] [nvarchar](1) NOT NULL,
	[fac_tot] [float] NOT NULL,
	[fac_ped] [int] NOT NULL,
	[fac_fec] [datetime] NOT NULL,
 CONSTRAINT [PK_facturas] PRIMARY KEY CLUSTERED 
(
	[fac_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[items_facturas]    Script Date: 21/02/2018 08:43:57 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[items_facturas](
	[itf_id] [int] IDENTITY(1,1) NOT NULL,
	[itf_fac] [int] NOT NULL,
	[itf_art] [int] NOT NULL,
	[itf_cant] [int] NOT NULL,
	[itf_sub_tot] [float] NOT NULL,
 CONSTRAINT [PK_items_facturas] PRIMARY KEY CLUSTERED 
(
	[itf_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[items_pedidos]    Script Date: 21/02/2018 08:43:57 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[items_pedidos](
	[ite_id] [int] IDENTITY(1,1) NOT NULL,
	[ite_ped] [int] NOT NULL,
	[ite_art] [int] NOT NULL,
	[ite_cant] [int] NOT NULL,
	[ite_cant_res] [int] NULL,
	[ite_sub_tot] [float] NOT NULL,
 CONSTRAINT [PK_items_pedidos] PRIMARY KEY CLUSTERED 
(
	[ite_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[items_remitos]    Script Date: 21/02/2018 08:43:57 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[items_remitos](
	[itr_id] [int] IDENTITY(1,1) NOT NULL,
	[itr_rem] [int] NOT NULL,
	[itr_art] [int] NOT NULL,
 CONSTRAINT [PK_items_remitos] PRIMARY KEY CLUSTERED 
(
	[itr_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[lotes]    Script Date: 21/02/2018 08:43:57 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[lotes](
	[lot_id] [int] IDENTITY(1,1) NOT NULL,
	[lot_nro] [nvarchar](50) NOT NULL,
	[lot_art] [int] NOT NULL,
	[lot_vto] [datetime] NOT NULL,
 CONSTRAINT [PK_lotes] PRIMARY KEY CLUSTERED 
(
	[lot_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[movimientos]    Script Date: 21/02/2018 08:43:57 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[movimientos](
	[mov_id] [int] IDENTITY(1,1) NOT NULL,
	[mov_art] [int] NOT NULL,
	[mov_tmo] [nvarchar](50) NOT NULL,
	[mov_destino] [nvarchar](50) NULL,
	[mov_autorizado] [nvarchar](50) NULL,
	[mov_encargado] [nvarchar](50) NULL,
	[mov_cant] [int] NOT NULL,
 CONSTRAINT [PK_movimientos] PRIMARY KEY CLUSTERED 
(
	[mov_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ordenes_compras]    Script Date: 21/02/2018 08:43:57 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ordenes_compras](
	[odc_id] [int] IDENTITY(1,1) NOT NULL,
	[odc_art] [int] NOT NULL,
	[odc_teo] [int] NOT NULL,
	[odc_cant_x_comprar] [int] NOT NULL,
	[odc_fec_recepcion] [datetime] NOT NULL,
	[odc_cant_res] [int],
 CONSTRAINT [PK_ordenes_compras] PRIMARY KEY CLUSTERED 
(
	[odc_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[pedidos]    Script Date: 21/02/2018 08:43:57 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pedidos](
	[ped_id] [int] IDENTITY(1,1) NOT NULL,
	[ped_cli] [int] NOT NULL,
	[ped_tep] [nvarchar](50) NOT NULL,
	[ped_fec_generacion] [datetime] NOT NULL,
	[ped_fec_entrega] [datetime],
	[ped_motivo_rechazo] [nvarchar](50) NULL,
	[ped_direc] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_pedidos] PRIMARY KEY CLUSTERED 
(
	[ped_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[remitos]    Script Date: 21/02/2018 08:43:57 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[remitos](
	[rem_id] [int] IDENTITY(1,1) NOT NULL,
	[rem_cli] [int] NOT NULL,
	[rem_ped] [int] NOT NULL,
 CONSTRAINT [PK_remitos] PRIMARY KEY CLUSTERED 
(
	[rem_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/****** Object:  Table [dbo].[ubicaciones]    Script Date: 21/02/2018 08:43:57 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ubicaciones](
	[ubi_id] [int] IDENTITY(1,1) NOT NULL,
	[ubi_cod] [nvarchar](50) NOT NULL,
	[ubi_art] [int] NOT NULL,
	[ubi_cal] [nvarchar](50) NOT NULL,
	[ubi_blo] [nvarchar](50) NOT NULL,
	[ubi_est] [nvarchar](50) NOT NULL,
	[ubi_pos] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ubicaciones] PRIMARY KEY CLUSTERED 
(
	[ubi_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[facturas]  WITH CHECK ADD  CONSTRAINT [FK_facturas_clientes] FOREIGN KEY([fac_cli])
REFERENCES [dbo].[clientes] ([cli_id])
GO
ALTER TABLE [dbo].[facturas] CHECK CONSTRAINT [FK_facturas_clientes]
GO
ALTER TABLE [dbo].[facturas]  WITH CHECK ADD  CONSTRAINT [FK_facturas_pedidos] FOREIGN KEY([fac_ped])
REFERENCES [dbo].[pedidos] ([ped_id])
GO
ALTER TABLE [dbo].[facturas] CHECK CONSTRAINT [FK_facturas_pedidos]
GO
ALTER TABLE [dbo].[items_facturas]  WITH CHECK ADD  CONSTRAINT [FK_items_facturas_articulos1] FOREIGN KEY([itf_art])
REFERENCES [dbo].[articulos] ([art_id])
GO
ALTER TABLE [dbo].[items_facturas] CHECK CONSTRAINT [FK_items_facturas_articulos1]
GO
ALTER TABLE [dbo].[items_facturas]  WITH CHECK ADD  CONSTRAINT [FK_items_facturas_facturas] FOREIGN KEY([itf_fac])
REFERENCES [dbo].[facturas] ([fac_id])
GO
ALTER TABLE [dbo].[items_facturas] CHECK CONSTRAINT [FK_items_facturas_facturas]
GO
ALTER TABLE [dbo].[items_pedidos]  WITH CHECK ADD  CONSTRAINT [FK_items_pedidos_articulos1] FOREIGN KEY([ite_art])
REFERENCES [dbo].[articulos] ([art_id])
GO
ALTER TABLE [dbo].[items_pedidos] CHECK CONSTRAINT [FK_items_pedidos_articulos1]
GO
ALTER TABLE [dbo].[items_pedidos]  WITH CHECK ADD  CONSTRAINT [FK_items_pedidos_pedidos1] FOREIGN KEY([ite_ped])
REFERENCES [dbo].[pedidos] ([ped_id])
GO
ALTER TABLE [dbo].[items_pedidos] CHECK CONSTRAINT [FK_items_pedidos_pedidos1]
GO
ALTER TABLE [dbo].[items_remitos]  WITH CHECK ADD  CONSTRAINT [FK_items_remitos_articulos] FOREIGN KEY([itr_art])
REFERENCES [dbo].[articulos] ([art_id])
GO
ALTER TABLE [dbo].[items_remitos] CHECK CONSTRAINT [FK_items_remitos_articulos]
GO
ALTER TABLE [dbo].[items_remitos]  WITH CHECK ADD  CONSTRAINT [FK_items_remitos_remitos1] FOREIGN KEY([itr_rem])
REFERENCES [dbo].[remitos] ([rem_id])
GO
ALTER TABLE [dbo].[items_remitos] CHECK CONSTRAINT [FK_items_remitos_remitos1]
GO
ALTER TABLE [dbo].[lotes]  WITH CHECK ADD  CONSTRAINT [FK_lotes_articulos1] FOREIGN KEY([lot_art])
REFERENCES [dbo].[articulos] ([art_id])
GO
ALTER TABLE [dbo].[lotes] CHECK CONSTRAINT [FK_lotes_articulos1]
GO
ALTER TABLE [dbo].[ordenes_compras]  WITH CHECK ADD  CONSTRAINT [FK_ordenes_compras_articulos1] FOREIGN KEY([odc_art])
REFERENCES [dbo].[articulos] ([art_id])
GO
ALTER TABLE [dbo].[ordenes_compras] CHECK CONSTRAINT [FK_ordenes_compras_articulos1]
GO

/* Se agrega asociacion entre pedidos y clientes*/
ALTER TABLE [dbo].[pedidos]  WITH CHECK ADD  CONSTRAINT [FK_pedidos_clientes] FOREIGN KEY([ped_cli])
REFERENCES [dbo].[clientes] ([cli_id])
GO

ALTER TABLE [dbo].[remitos]  WITH CHECK ADD  CONSTRAINT [FK_remitos_pedidos1] FOREIGN KEY([rem_ped])
REFERENCES [dbo].[pedidos] ([ped_id])
GO
ALTER TABLE [dbo].[remitos] CHECK CONSTRAINT [FK_remitos_pedidos1]
GO
ALTER TABLE [dbo].[ubicaciones]  WITH CHECK ADD  CONSTRAINT [FK_ubicaciones_articulos1] FOREIGN KEY([ubi_art])
REFERENCES [dbo].[articulos] ([art_id])
GO
ALTER TABLE [dbo].[ubicaciones] CHECK CONSTRAINT [FK_ubicaciones_articulos1]
GO
