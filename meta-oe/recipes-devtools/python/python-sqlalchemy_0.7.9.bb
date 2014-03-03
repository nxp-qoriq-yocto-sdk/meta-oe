DESCRIPTION = "Python SQL toolkit and Object Relational Mapper that gives \
application developers the full power and flexibility of SQL"
HOMEPAGE = "http://www.sqlalchemy.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=baffc5e5f4804c92fc9be155fed70d41"
RDEPENDS_${PN} += "python-numbers"

SRCNAME = "SQLAlchemy"
SRC_URI = "https://pypi.python.org/packages/source/S/SQLAlchemy/${SRCNAME}-${PV}.tar.gz"
SRC_URI[md5sum] = "a0b58defc5ad0c7e1baeb932f62d08dd"
SRC_URI[sha256sum] = "4a89556cb55275d1af694dc4d5700d8bf0f83690bac16ab30340092ff25bb4d7"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
