DESCRIPTION = "udpxy"
MAINTAINER = "Pavel V. Cherenkov"
SECTION = "multimedia"
PRIORITY = "optional"
LICENSE = "GPLv2"

require conf/license/license-gplv2.inc

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "2.0+git${SRCPV}"
PKGV = "2.0+git${GITPKGV}"
PV = "0.23"
PR = "r0"

inherit autotools pkgconfig

SRC_URI = "git://github.com/pcherenkov/udpxy.git"

S = "${WORKDIR}/git/chipmunk"

FILES_${PN} = "${bindir}/*"

do_compile() {
	make -f Makefile udpxy
}

do_install() {
	install -d ${D}/${bindir}
	install -m 755 ${S}/udpxy ${D}/${bindir}
}

