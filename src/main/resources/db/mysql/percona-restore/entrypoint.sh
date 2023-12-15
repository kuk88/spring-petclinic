#!/bin/bash

echo "backup file $1"
xbstream -x --directory=/restore < /backup/$1 && \
xtrabackup --prepare --target-dir=/restore && \
mv /restore/* /var/lib/mysql/
