# Copyright (C) 2020, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-yocto.inc
require linux-rockchip.inc

inherit freeze-rev

SRCREV = "64b3c2cf3c7ace72a19aea709db77ccc5ca47722"
SRC_URI = " \
	git://github.com/JeffyCN/mirrors.git;branch=kernel-4.19; \
	file://cgroups.cfg \
"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KERNEL_VERSION_SANITY_SKIP = "1"
LINUX_VERSION ?= "4.19"

SRC_URI_append += "${@bb.utils.contains('IMAGE_FSTYPES', 'ext4', \
		   ' file://ext4.cfg', \
		   '', \
		   d)}"
