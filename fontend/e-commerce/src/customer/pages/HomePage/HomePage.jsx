import React from "react";
import MainCarosel from "../../components/HomeCarosel/MainCarosel";
import HomeSectionCarosel from "../../components/HomeSectionCarosel/HomeSectionCarosel";
import { mens } from "../../../data/mens";

const HomePage = () => {
  return (
    <div>
      <MainCarosel />
      <div className="space-y-10 py-20 flex flex-col justify-center px-5 lg:px-10">
        <HomeSectionCarosel data={mens} sectionName={"Áo Dài Nam"} />
        <HomeSectionCarosel data={mens} sectionName={"Giày Nam"} />
        <HomeSectionCarosel data={mens} sectionName={"Sơ Mi Nam"} />
        <HomeSectionCarosel data={mens} sectionName={"Áo Dài Nữ"} />
        <HomeSectionCarosel data={mens} sectionName={"Váy Nữ"} />
      </div>
    </div>
  );
};

export default HomePage;
