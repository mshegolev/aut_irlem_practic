# Run tests

## Use Maven
Open a console and run:

    ./mvn test

# Jenkins configuration
## Unpack backup for Centos 7 to /var/lib/jenkins
    wget https://drive.google.com/file/d/1w7CaIUXxwQ1pH9WSy7DzyhEb81f7_pfL/view?usp=sharing
### Encrypt

    tar cz folder_to_encrypt | \
      openssl enc -aes-256-cbc -e > out.tar.gz.enc

### Decrypt

    openssl enc -aes-256-cbc -d -in out.tar.gz.enc | tar xz"
