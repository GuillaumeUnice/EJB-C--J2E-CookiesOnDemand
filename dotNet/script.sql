USE [master]
GO
/****** Object:  Database [CoD]    Script Date: 04/21/2015 15:19:01 ******/
CREATE DATABASE [CoD] ON  PRIMARY 
( NAME = N'CoD', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\CoD.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'CoD_log', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\CoD_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [CoD] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [CoD].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [CoD] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [CoD] SET ANSI_NULLS OFF
GO
ALTER DATABASE [CoD] SET ANSI_PADDING OFF
GO
ALTER DATABASE [CoD] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [CoD] SET ARITHABORT OFF
GO
ALTER DATABASE [CoD] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [CoD] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [CoD] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [CoD] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [CoD] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [CoD] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [CoD] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [CoD] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [CoD] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [CoD] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [CoD] SET  DISABLE_BROKER
GO
ALTER DATABASE [CoD] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [CoD] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [CoD] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [CoD] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [CoD] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [CoD] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [CoD] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [CoD] SET  READ_WRITE
GO
ALTER DATABASE [CoD] SET RECOVERY SIMPLE
GO
ALTER DATABASE [CoD] SET  MULTI_USER
GO
ALTER DATABASE [CoD] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [CoD] SET DB_CHAINING OFF
GO
USE [CoD]
GO
/****** Object:  Table [dbo].[User]    Script Date: 04/21/2015 15:19:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[User](
	[Email] [varchar](50) NOT NULL,
	[Mdp] [varchar](50) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Payment]    Script Date: 04/21/2015 15:19:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Payment](
	[IdCommande] [bigint] NOT NULL,
	[User] [varchar](50) NULL,
 CONSTRAINT [PK_Payment] PRIMARY KEY CLUSTERED 
(
	[IdCommande] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  ForeignKey [FK_Payment_User1]    Script Date: 04/21/2015 15:19:02 ******/
ALTER TABLE [dbo].[Payment]  WITH CHECK ADD  CONSTRAINT [FK_Payment_User1] FOREIGN KEY([User])
REFERENCES [dbo].[User] ([Email])
GO
ALTER TABLE [dbo].[Payment] CHECK CONSTRAINT [FK_Payment_User1]
GO
