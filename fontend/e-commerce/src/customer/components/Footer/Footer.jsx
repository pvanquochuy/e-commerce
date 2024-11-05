import { Button, Grid, Typography } from "@mui/material";
import React from "react";
import { Link } from "react-alice-carousel";

const Footer = () => {
  return (
    <div>
      <Grid
        className="bg-black text-white text-center mt-10"
        container
        sx={{ bgcolor: "black", color: "white", py: 3 }}
      >
        <Grid item xs={12} sm={6} md={3}>
          <Typography className="pb-5" variant="h6">
            {" "}
            Thông tin{" "}
          </Typography>
          <div>
            <Button className="pb-5" variant="h6">
              {" "}
              About{" "}
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6">
              {" "}
              Blog{" "}
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6">
              {" "}
              Press{" "}
            </Button>
          </div>

          <div>
            <Button className="pb-5" variant="h6">
              {" "}
              Jobs
            </Button>
          </div>

          <div>
            <Button className="pb-5" variant="h6">
              {" "}
              Partners
            </Button>
          </div>
        </Grid>
        <Grid item xs={12} sm={6} md={3}>
          <Typography className="pb-5" variant="h6">
            Công ty
          </Typography>
          <div>
            <Button className="pb-5" variant="h6">
              Giới thiệu
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6">
              Bài viết
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6">
              Press
            </Button>
          </div>

          <div>
            <Button className="pb-5" variant="h6">
              Jobs
            </Button>
          </div>

          <div>
            <Button className="pb-5" variant="h6">
              Partners
            </Button>
          </div>
        </Grid>

        <Grid item xs={12} sm={6} md={3}>
          <Typography className="pb-5" variant="h6">
            Company
          </Typography>
          <div>
            <Button className="pb-5" variant="h6">
              About
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6">
              Blog
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6">
              Press
            </Button>
          </div>

          <div>
            <Button className="pb-5" variant="h6">
              Jobs
            </Button>
          </div>

          <div>
            <Button className="pb-5" variant="h6">
              Partners
            </Button>
          </div>
        </Grid>

        <Grid item xs={12} sm={6} md={3}>
          <Typography className="pb-5" variant="h6">
            Company
          </Typography>
          <div>
            <Button className="pb-5" variant="h6">
              About
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6">
              Blog
            </Button>
          </div>
          <div>
            <Button className="pb-5" variant="h6">
              Press
            </Button>
          </div>

          <div>
            <Button className="pb-5" variant="h6">
              Jobs
            </Button>
          </div>

          <div>
            <Button className="pb-5" variant="h6">
              Partners
            </Button>
          </div>
        </Grid>

        <Grid className="pt-20" item xs={12}>
          <Typography variant="body2" component="p" align="center">
            &copy; 2023 My Company. All right reserved.
          </Typography>
          <Typography variant="body2" component="p" align="center">
            Made with love by me
          </Typography>
          <Typography variant="body2" component="p" align="center">
            Icons made by{" "}
            <Link href="#" color="inherit" underline="always">
              Freepik
            </Link>{" "}
            from
            <Link href="#" color="inherit" underline="always">
              Freepik
            </Link>{" "}
          </Typography>
        </Grid>
      </Grid>
    </div>
  );
};

export default Footer;
