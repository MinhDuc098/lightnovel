
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[uID] [int] IDENTITY(1,1) NOT NULL,
	[user] [varchar](255) NULL,
	[pass] [varchar](255) NULL,
	[isAdmin] [int] NULL,
	[isUser] [varchar](150) NULL,
	[email] varchar(300),
PRIMARY KEY CLUSTERED 
(
	[uID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]




SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[cid] [int] identity(1,1) NOT NULL,
	[cname] [nvarchar](50) NOT NULL,
 PRIMARY KEY CLUSTERED 

(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO





SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create table lightnovel(
	nid int IDENTITY(1,1) NOT NULL,
	numOfChap int,
	chapId int,
	[name] varchar(100) not null,
	otherName varchar(100),
	cid int,
	img varchar(max),
	[des] varchar(max),
	status varchar(50),

PRIMARY KEY CLUSTERED 
(
	nid ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

create table catenovel(
	cid int references Category(cid),
	nid int references lightnovel(nid),
	primary key(cid,nid),
)

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create table chapter(
	chapId int IDENTITY(1,1) NOT NULL,
	chapname varchar(15),
	[file] varchar(max),
	nid int references lightnovel(nid),
PRIMARY KEY CLUSTERED 
(
	chapId ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]



create table comment(
	nid int ,
	[uID] int, 
	comment varchar(max),
	
)

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create table ban(
	banid int IDENTITY(1,1) not null,
	[uID] int not null,
	primary key([uID])
	
)

