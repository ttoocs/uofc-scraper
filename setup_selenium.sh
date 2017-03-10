if [ ! -e ./setup_selenium.sh ]; then
  echo "This script doesn't work anywhere else."
fi

#MAKE THE DIRECTORY
mkdir ./selenium
cd ./selenium

#DL THE FILE THING:
wget "http://selenium-release.storage.googleapis.com/3.3/selenium-java-3.3.0.zip"

#UNZIP IT
unzip selenium-java-3.3.0.zip

#AND DELETE IT CAUSE IDK.
rm selenium-java-3.3.0.zip

