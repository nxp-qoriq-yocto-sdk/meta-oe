DESCRIPTION = "strongSwan is an OpenSource IPsec implementation for the \
Linux operating system."
HOMEPAGE = "http://www.strongswan.org"
SECTION = "console/network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
DEPENDS = "gmp openssl flex-native flex bison-native"

SRC_URI = "http://download.strongswan.org/strongswan-${PV}.tar.bz2 \
    file://0001-Add-fix-when-checking-the-wiping-of-cryptographic-se.patch"
SRC_URI[md5sum] = "0ab0397b44b197febfd0f89148344035"
SRC_URI[sha256sum] = "3ec66d64046f652ab7556b3be8f9be8981fd32ef4a11e3e461a04d658928bfe2"

EXTRA_OECONF = "--disable-curl --disable-soup --disable-ldap \
        --enable-gmp --disable-mysql --disable-sqlite \
        --enable-openssl"

EXTRA_OECONF += "${@base_contains('DISTRO_FEATURES', 'systemd', '--with-systemdsystemunitdir=${systemd_unitdir}/system/', '--without-systemdsystemunitdir', d)}"

inherit autotools systemd

RRECOMMENDS_${PN} = "kernel-module-ipsec"

PACKAGES += "${PN}-plugins"
FILES_${PN} += "${libdir}/ipsec/lib*${SOLIBS}"
FILES_${PN}-dev += "${libdir}/ipsec/lib*${SOLIBSDEV} ${libdir}/ipsec/*.la"
FILES_${PN}-staticdev += "${libdir}/ipsec/*.a"
FILES_${PN}-dbg += "${libdir}/ipsec/.debug ${libdir}/ipsec/plugins/.debug ${libexecdir}/ipsec/.debug"
FILES_${PN}-plugins += "${libdir}/ipsec/plugins/*"

INSANE_SKIP_${PN}-plugins = "staticdev"

RPROVIDES_${PN} += "${PN}-systemd"
RREPLACES_${PN} += "${PN}-systemd"
RCONFLICTS_${PN} += "${PN}-systemd"
SYSTEMD_SERVICE_${PN} = "${PN}.service"
